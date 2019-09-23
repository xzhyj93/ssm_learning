import com.mapper.StudentMapper;
import com.model.Courses;
import com.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        String resouce = "mybatis.cfg.xml";

        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        selectStudentCouse();
    }

    private static void selectStudentCouse(){
        SqlSession session = sqlSessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            List<Student> students = mapper.selectStudentCourse();
            session.commit();
            for (Student stu:students) {
                System.out.println(stu.toString());
                List<Courses> courses = stu.getCourses();
                for (Courses cou:courses) {
                    System.out.println(cou.toString());
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
}
