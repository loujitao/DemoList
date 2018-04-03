package filter;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.springframework.jdbc.core.JdbcTemplate;

/** 
* @author 作者 ：walker 
* @time 创建时间：2017年12月25日 下午5:28:56 
* @describe 
*/
public class AmqPlugin implements BrokerPlugin {
	
	private JdbcTemplate jdbcTemplate;//注入了spring-jdbc
	
    public AmqPlugin(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
	
	public Broker installPlugin(Broker broker) throws Exception {
		return new IpAuthFilter(broker,jdbcTemplate);
	}

}
