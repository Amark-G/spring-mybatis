import com.itheima.config.SpringConfig;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SelectTest {

    @Test
    public void selectById(){
        int id=6;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandService brandService = ctx.getBean(BrandService.class);
        Brand brand = brandService.selectById(id);
        System.out.println(brand);

    }
}
