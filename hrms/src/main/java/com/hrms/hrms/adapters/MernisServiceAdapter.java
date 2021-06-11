package com.hrms.hrms.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import com.hrms.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CandidateUserCheckService {

	@Override
	public boolean checkRealPerson(Candidate candidate) {
		
		var result= true;
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		try {
			result = client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentityNumber()), 
					candidate.getFirstName().toUpperCase(new Locale("tr")), 
					candidate.getLastName().toUpperCase(new Locale("tr")), 
					Integer.parseInt(candidate.getBirthYear())
							);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
