import com.P.mapper.UserMapper;
import com.P.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.P.utils.sqlSessionUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class insertTest {


    @Test
    public void Insert() {

        SqlSession sqlSession = sqlSessionUtils.sqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(null, "pan", 12, "男");
        User user2 = new User(null, "jian", 13, "女");
        List<User> list = Arrays.asList(user1, user2);
        mapper.insertUser(list);


    }

    @Test
    public void GetI() {

        SqlSession sqlSession = sqlSessionUtils.sqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers(1, 13);

        for (int i = 0; i < users.size(); i ++) {
            System.out.println(users.get(i));
        }

        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
