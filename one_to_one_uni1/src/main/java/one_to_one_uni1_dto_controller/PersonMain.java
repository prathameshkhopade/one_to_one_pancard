package one_to_one_uni1_dto_controller;

import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateContinue;

import one_to_one_uni1_dao.PersonCRUD;
import one_to_one_uni1_dto.PanCard;
import one_to_one_uni1_dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PanCard panCard = new PanCard();
		Person person = new Person();
		PersonCRUD personCRUD = new PersonCRUD();
		boolean flag = true;

		do {
			System.out.println(
					"choose below option \n 1: inserted \n 2: update \n 3: delete \n 4: get by id \n 5: retrive all ");
			System.out.println("enter you choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter panCard id :");
				int panid = scanner.nextInt();
				System.out.println("entere pancard name : ");
				String panName = scanner.next();
				System.out.println("enter address to be printed on pancard : ");
				String panaddress = scanner.next();
				panCard.setPanId(panid);
				panCard.setPanName(panName);
				panCard.setAddress(panaddress);

				System.out.println("enter person id : ");
				int id = scanner.nextInt();
				System.out.println("enter person name : ");
				String pname = scanner.next();
				System.out.println("enter person phone : ");
				String pPhone = scanner.next();
				System.out.println("enter person address : ");
				String paddress = scanner.next();

				person.setPersonId(panid);
				person.setPersonName(panName);
				person.setPersonPhone(pPhone);
				person.setPersonAddress(panaddress);
				person.setPanCard(panCard);

				personCRUD.savePerson(person);
				break;
			}
			case 2: {
				System.out.println("enter person id : ");
				int pid = scanner.nextInt();
				System.out.println("enter name : ");
				String name = scanner.next();
				person.setPersonId(pid);
				person.setPersonName(name);

				personCRUD.updatePerson(person);
				break;
			}
			case 3: {
				System.out.println("enter person id : ");
				int pid = scanner.nextInt();
				personCRUD.DeletePerson(pid);
			}
			case 4: {
				System.out.println("enter id by id : ");
				int id = scanner.nextInt();
				personCRUD.GetById(id);
				break;
			}
			case 5: {
				personCRUD.GetPersonAll();
			}

			default:
				break;
			}
		} while (flag);

	}

}
