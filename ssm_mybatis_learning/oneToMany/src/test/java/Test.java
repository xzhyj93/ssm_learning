import com.mapper.ClassesMapper;
import com.model.Classes;
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
        String resource = "mybatis.cfg.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        ClassesMapper mapper = session.getMapper(ClassesMapper.class);

        try {
            Classes classes = mapper.selectClassAndStudentsById(1);
            session.commit();
            System.out.println("班级信息" + classes.toString());
            List<Student> students = classes.getStudents();
            System.out.println("班级所有学生信息：");
            for(Student stu:students) {
                System.out.println(stu.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        //释放资源
        session.close();

    }
}
