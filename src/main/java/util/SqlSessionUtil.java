//package util;
//
//import org.apache.ibatis.session.SqlSession;
//
//public class SqlSessionUtil {
//
//    public DataConnection dataConn = new DataConnection();
//
//    private SqlSessionUtil(){
//
//    }
//
//    static {
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    /*
//     * 创建工厂
//     *
///*
// * 创建工厂
// */
//        this.sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
//        /*
//         * 打开ssion
//         */
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
//        System.out.println(sqlSession);
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = userMapper.selectUsersbyUserName("刘");
//    }
//    SqlSession
//    public static SqlSession getSqlSession(){
//
//    }
//}
//
//    InputStream inputStream = null;
//    try {
//            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//            } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            }
//    /*
//     * 创建工厂
//     *
///*
// * 创建工厂
// */
//    this.sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
//            /*
//             * 打开ssion
//             */
//            SqlSession sqlSession = this.sqlSessionFactory.openSession();
//            System.out.println(sqlSession);
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = userMapper.selectUsersbyUserName("刘");
