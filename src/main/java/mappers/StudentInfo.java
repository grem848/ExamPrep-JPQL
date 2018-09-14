
package mappers;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="StudentInfo")
public class StudentInfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String fullName;
    public long studentId;
    public String classNameThisSemester;
    public String classDescription;


    public StudentInfo()
    {
    }

    public StudentInfo(String fullName, long studentId, String classNameThisSemester, String classDescription)
    {
        this.fullName = fullName;
        this.studentId = studentId;
        this.classNameThisSemester = classNameThisSemester;
        this.classDescription = classDescription;
    }

    
    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(long studentId)
    {
        this.studentId = studentId;
    }

    public String getClassNameThisSemester()
    {
        return classNameThisSemester;
    }

    public void setClassNameThisSemester(String classNameThisSemester)
    {
        this.classNameThisSemester = classNameThisSemester;
    }

    public String getClassDescription()
    {
        return classDescription;
    }

    public void setClassDescription(String classDescription)
    {
        this.classDescription = classDescription;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "StudentInfo id: " + id + ", Student Name: " + fullName + ", Class Name: " + classNameThisSemester + ", Class Description: " +classDescription + "\n";
    }

}
