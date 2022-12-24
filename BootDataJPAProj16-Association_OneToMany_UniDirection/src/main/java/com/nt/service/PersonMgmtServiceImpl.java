package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IPersonRepository;
import com.nt.Repository.IPhoneNumberRepository;
import com.nt.modul.Person;
import com.nt.modul.PhoneNumbers;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtServiceImpl {

	@Autowired
	private IPersonRepository perRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public String RegistorPerson(Person person) {
		// TODO Auto-generated method stub
		return " Person Saved wiht id " + perRepo.save(person).getPid() + " , Thnak you for using our service. ";
	}

	@Override
	public void LoadDataUsingParent() {

		List<Person> per = perRepo.findAll();

		per.forEach(par -> {
			System.out.println("Parent : " + per);
			Set<PhoneNumbers> phone = par.getPhoneNumbers();
			phone.forEach(ch -> {
				System.out.println("Child : " + ch);
			});
		});

	}

	@Override
	public String deleteParentAndChilds(int pid) {

		Optional<Person> op = perRepo.findById(pid);

		if (op.isPresent()) {
			perRepo.delete(op.get());
			return pid + " is deleted succuesfully with it child's";
		} else {
			return pid + " is not found !!";
		}
	}
	
	@Override
	public String deleteAllPhoneNumbersOfPerson(int pid) {

		//load parent on bject's
		/*Optional<PhoneNumbers> op=phoneRepo.findById(pid);
		if (op.isPresent()) {
			phoneRepo.delete(op.get());
			return pid + " is deleted succuesfully";
		} else {
			return pid + " is not found !!";
		}*/
		Optional<Person> op=perRepo.findById(pid);
		if(op.isPresent()){
			Set<PhoneNumbers> phone=op.get().getPhoneNumbers();
			phoneRepo.deleteAll();
			return pid + " is deleted succuesfully";
		}
		
		return pid + " is not found !!";
	}
	
	@Override
	public String saveOnlyChild(List<PhoneNumbers> phno) {
		// TODO Auto-generated method stub
		return "child saved succesfully !! , "+phoneRepo.saveAll(phno);
	}

}
