package service;

import com.google.common.collect.Lists;
import dao.Mapper;
import dimensionRawData.DDrivers;
import dimensionScored.DDriversScored;
import entity.Drivers;
import org.apache.ibatis.session.SqlSession;
import util.DataConnection;
import util.KF4DScoreFunctionUtils;

import java.io.IOException;
import java.util.List;

public class DriversDimensionScoreService {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;

    static
    {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DDriversScored> getDriversScores() {



        List<DDriversScored> dDriversScoredList = Lists.newArrayList();

        // TODO get DExperiences from DB and replace
        // transfer from string to it
        try{
            List<DDrivers> dDriversList = Lists.newArrayList();
            List<Drivers> driversList =  mapper.getAllDrivers();
            sqlSession.commit();
            driversList.forEach(drivers -> {
                DDrivers dDrivers = new DDrivers(drivers.getWwid(),drivers.getBalance(),drivers.getChallenge(),drivers.getCollaboration(),drivers.getIndependence(),drivers.getPower(),drivers.getStructure());
                dDriversList.add(dDrivers);
            });


            for (DDrivers dDrivers : dDriversList) {
                DDriversScored dTraitsScored = new DDriversScored(dDrivers.getWwid(), KF4DScoreFunctionUtils.calcDriversScore(dDrivers.getDrivers()));
                dDriversScoredList.add(dTraitsScored);
                System.out.println(dTraitsScored.getResult());
            }
            return dDriversScoredList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



    public static void main(String args[]){

        getDriversScores();

//        String balance = "4.0";
//        System.out.println(Double.valueOf(balance).intValue());
    }
}
