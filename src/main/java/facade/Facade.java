package facade;

import entity.Semester;
import entity.Student;
import static entity.Student_.id;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Facade
{

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public List<Student> getAllStudents()
    {
        EntityManager em = getEntityManager();

        TypedQuery<Student> qt = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> studentList = qt.getResultList();
        return studentList;

    }

    public List<Student> getAllStudentsFromName(String name)
    {
        EntityManager em = getEntityManager();

        Query q = em.createQuery("select c from Student c where c.firstname = :name");
        q.setParameter("name", name);

        List<Student> studentList = q.getResultList();
        return studentList;

    }

    public Student createStudent(Student st)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();

            em.persist(st);

            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return st;
    }

    public Student StudentAssignSemester(long stuid, long semid)
    {

        EntityManager em = getEntityManager();

        try
        {
            em.getTransaction().begin();
            Student stu = em.find(Student.class, stuid);
            Semester sem = em.find(Semester.class, semid);

            if (stu != null)
            {
                stu.setSemester(sem);
                em.merge(stu);
            }
            em.getTransaction().commit();
            return stu;
        } finally
        {
            em.close();
        }
    }

    public List<Student> getAllStudentsFromLastName(String name)
    {
        EntityManager em = getEntityManager();

        Query q = em.createQuery("select c from Student c where c.lastname = :name");
        q.setParameter("name", name);

        List<Student> studentList = q.getResultList();
        return studentList;

    }
    
    public long getAllStudentsFromSemester(String semname)
    {
        EntityManager em = getEntityManager();

        Query q = em.createQuery("select COUNT(c) from Student c where c.semester.name = :name");
        q.setParameter("name", semname);
        long result = (long) q.getSingleResult();
        return result;

    }
    
    public long getAllStudentsFromAllSemesters()
    {
        EntityManager em = getEntityManager();

        Query q = em.createQuery("select COUNT(c) from Student c WHERE c.semester.name IS NOT NULL");

        long result = (long) q.getSingleResult();
        return result;

    }
    
    
    
    
    
    
    
}
