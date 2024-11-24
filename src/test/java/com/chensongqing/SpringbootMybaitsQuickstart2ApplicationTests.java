package com.chensongqing;
import com.chensongqing.mapper.DeptMapper;
import com.chensongqing.pojo.Dept;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.List;

@SpringBootTest
class SpringbootMybaitsQuickstart2ApplicationTests {
    @Autowired
    private DeptMapper deptmapper;
    @Test
    public void selectshow() {
        List<Dept> c= deptmapper.list();
        System.out.println(c);
    }

    @Test
    public void inserttest(){
        Dept u = new Dept();
        u.setName("ct");
        u.setAge(18);
        u.setGender(1);
        u.setPhone("265841");
        deptmapper.insert(u);
    }
    @Test
   public void delettest(){
//        List<Integer> user= Arrays.asList(7);
        deptmapper.delete(8);
    }


    @Nested
    class BeanInspector {

        private final ApplicationContext context;

        public BeanInspector(ApplicationContext context) {
            this.context = context;
        }
        @Test
        public void inspectBeans() {
            String[] beanNames = context.getBeanDefinitionNames();
            for (String name : beanNames) {
                System.out.println("Bean name: " + name);
                Object bean = context.getBean(name);
                System.out.println("Bean class: " + bean.getClass());
            }
        }
    }

}
