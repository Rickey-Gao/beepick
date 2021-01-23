package com.example.mybatis_demo;


import com.example.mybatis_demo.bean.GeoLocation;
import com.example.mybatis_demo.dao.GeoLocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BeepickApplicationTests {

    @Autowired
    private MongoTemplate template;

    @Autowired
    private GeoLocationDao geoLocationDao;

    @Test
    public  void doQuery()
    {
        //查询  KILOMETERS
        Point point = new Point(118.783799, 31.979234);
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.limit(20);
        //NearQuery nq = NearQuery.near(point.getX(),point.getY(), Metrics.KILOMETERS).maxDistance(new Double(200));
        NearQuery nq = NearQuery.near(point.getX(),point.getY(), Metrics.KILOMETERS).maxDistance(new Double(400));
        GeoResults<GeoLocation> empGeoResults = template.geoNear(nq, GeoLocation.class);
        if (empGeoResults != null) {
            for (GeoResult<GeoLocation> e : empGeoResults) {
                System.out.println("\ne.toString() ================ " + e.toString());
            }
        }

    }

}
