package one_to_one_uni1_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni1_dto.PanCard;
import one_to_one_uni1_dto.Person;

public class PersonCRUD {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = person.getPanCard();

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(panCard);
		entityTransaction.commit();

	}

	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person2 = entityManager.find(Person.class, person.getPersonId());
		PanCard panCard = person2.getPanCard();

		person2.setPersonName(person.getPersonName());
		panCard.setPanName(person.getPersonName());

		entityTransaction.begin();
		entityManager.merge(person2);
		entityManager.merge(panCard);
		entityTransaction.commit();

		System.out.println("data update sucessfully");

	}

	public void DeletePerson(int id) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		PanCard panCard = person.getPanCard();
		if (person != null) {

			entityTransaction.begin();

			entityManager.remove(panCard);
			entityManager.remove(person);
			
			entityTransaction.commit();
			System.out.println("data delete sucessfully");
		}
	}

	public void GetById(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		entityTransaction.begin();
		System.out.println(person);
		entityTransaction.commit();
		System.out.println(" sucessfully we retrive data by using id");
	}

	public void GetPersonAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		 List list = query.getResultList();
		System.out.println(list);
		System.out.println("sucessfully we fetch all data");
	}

}
