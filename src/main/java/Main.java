import Entitati.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityManager.getTransaction().begin();

        BookDetails bookDetails1=new BookDetails(1,"Cay S. Horstmann",  "Core Java Fundamentals", 550.0, "98976366733", "In stock");
        BookDetails bookDetails2=new BookDetails(2, "Joshua Bloch", "Effective Java", 220.0,"989745454545", "In stock");
        BookDetails bookDetails3=new BookDetails(3, "Anthony Molinaro", "Programming Algorithms", 125.0, "9434334323232", "In stock");
        BookDetails bookDetails4=new BookDetails(4, "Chris Fehily", "SQL Programming", 520.0, "9834433343434", "In stock");
        BookDetails bookDetails5=new BookDetails(5, "Anthony Molinaro", "Programming Algorithms", 256.0, "9834433343434", "In stock");

        BookTransaction bookTransaction1=new BookTransaction(1, 10.0, new Date(), "holding");
        BookTransaction bookTransaction2=new BookTransaction(2, 10.0, new Date(), "holding");
        BookTransaction bookTransaction3=new BookTransaction(3, 20.0, new Date(), "holding");

        StudentDetails studentDetails1=new StudentDetails(1, "Popescu Mihai", "310440501RSL123456", "Iasi, strada Mihai Voda IV, nr. 1900 ", 20, "Holding 3 books");
        StudentDetails studentDetails2=new StudentDetails(2, "Popa Genoveva", "310440501RSL189002", "Barlad, strada Costache Negruzzi, nr. 990", 20,"Holding 5 books" );
        StudentDetails studentDetails3=new StudentDetails(3, "Lupu Violeta", "310440501RSL192028", "Iasi, strada Mihai Voda I, nr. 22",20, "Holding 5 books");
        StudentDetails studentDetails4=new StudentDetails(4, "Robescu Dragos", "310440501RSL191023", "Pascani, strada Florilor, nr. 189", 20, "Holding 2 books");

        bookTransaction1.setTransactionBooks(studentDetails1);
        bookTransaction1.setBookDetails(bookDetails1);

        bookTransaction2.setTransactionBooks(studentDetails2);
        bookTransaction2.setBookDetails(bookDetails2);

        bookTransaction3.setTransactionBooks(studentDetails3);
        bookTransaction3.setBookDetails(bookDetails3);

        List<BookTransaction> bookTransactionList=new ArrayList<BookTransaction>();
        bookTransactionList.add(bookTransaction1);
        bookTransactionList.add(bookTransaction2);
        bookTransactionList.add(bookTransaction3);

        studentDetails1.setBookTransactions(bookTransactionList);

        UserDetails userDetails1=new UserDetails(1, "Ionescu Alin", "ionescu", "alinionescu1234", "ionescu.m121@gmail.com","0789231920");
        UserDetails userDetails2=new UserDetails(2, "Silica Marius", "silicaMarius", "silicam890", "silica.marius21@gmail.com", "0726789900");
        UserDetails userDetails3=new UserDetails(3, "Chirila Andrei", "chirilaA", "chirilaand7890", "chirila.andrei@gmail.com", "0745670299");

        List<BookDetails> bookDetailsList=new ArrayList<BookDetails>();
        bookDetailsList.add(bookDetails1);
        bookDetailsList.add(bookDetails2);
        bookDetailsList.add(bookDetails3);

        OrderBooks orderBook1=new OrderBooks(1, new Date());
        orderBook1.setStudentDetails(studentDetails1);
        orderBook1.setBooks(bookDetailsList);

        OrderBooks orderBook2=new OrderBooks(2, new Date());
        orderBook2.setUserDetails(userDetails1);


        LeaderTeam leaderTeam1=new LeaderTeam(1, "Sireteanu Mihai", "JavaScript, HTML, CSS, node");
        LeaderTeam leaderTeam3=new LeaderTeam(2, "Strimbei Codrin", "JEE, Spring, .NET, JS/Node.js, Ruby_Rails");

        Team team1=new Team(1, "Fronted", leaderTeam1);
        Team team2=new Team(2, "Backend", leaderTeam1);
        Team team3=new Team(3, "Business", leaderTeam3);

        Role role1=Role.Analyst;
        Role role2=Role.Developer;
        Role role3=Role.Manager;
        Role role4=Role.Tester;

        Employee employee1=new Employee(100,  new Date());
        employee1.setName("Vasiliu Stefan");
        employee1.setRole(role4);
        employee1.setTeam(team2);

//        "Condureanu Alexandra", role3,

        Employee employee2=new Employee(200, new Date());
        employee2.setName("Condureanu Alexandra");
        employee2.setRole(role3);
        employee2.setTeam(team3);

        Employee employee3=new Employee(300, new Date());
        employee3.setName("Pricop Ana");
        employee3.setRole(role2);
        employee3.setTeam(team1);

        Employee employee4=new Employee(400, new Date());
        employee4.setName("Mihai Andrei");
        employee4.setRole(role4);
        employee4.setTeam(team2);


        Employee employee5 =new Employee(500, new Date());
        employee5.setName("Hariga Iuliana");
        employee5.setRole(role1);
        employee5.setTeam(team3);

        Employee employee6 =new Employee(600, new Date());
        employee6.setName("Musteata Alina");
        employee6.setRole(role2);
        employee6.setTeam(team1);




        entityManager.persist(bookDetails1);
        entityManager.persist(bookDetails2);
        entityManager.persist(bookDetails3);
        entityManager.persist(bookDetails4);
        entityManager.persist(bookDetails5);
        entityManager.persist(bookTransaction1);
        entityManager.persist(bookTransaction2);
        entityManager.persist(bookTransaction3);
        entityManager.persist(studentDetails1);
        entityManager.persist(studentDetails2);
        entityManager.persist(studentDetails3);
        entityManager.persist(studentDetails4);
        entityManager.persist(userDetails1);
        entityManager.persist(userDetails2);
        entityManager.persist(userDetails3);
        entityManager.persist(orderBook1);
        entityManager.persist(orderBook2);
        entityManager.persist(leaderTeam1);
        entityManager.persist(leaderTeam3);
        entityManager.persist(team1);
        entityManager.persist(team2);
        entityManager.persist(team3);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.persist(employee5);
        entityManager.persist(employee6);
        entityManager.getTransaction().commit();

    }
}
