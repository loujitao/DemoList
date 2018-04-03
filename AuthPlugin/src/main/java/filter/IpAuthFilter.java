package filter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;

/** 
* @author 作者 ：walker 
* @time 创建时间：2017年12月25日 下午3:40:12 
* @describe 
*/
public class IpAuthFilter extends BrokerFilter {
	

	private static final Logger log = LoggerFactory.getLogger(IpAuthFilter.class);
	
	private org.springframework.jdbc.core.JdbcTemplate JdbcTemplate;
	
	public IpAuthFilter(Broker broker, JdbcTemplate jdbcTemplate2) {
		super(broker);
		this.JdbcTemplate=jdbcTemplate2;
	}

	@Override
	public void addConnection(ConnectionContext context, ConnectionInfo info) throws Exception {
		String sql="SELECT * FROM amq_apply WHERE systemIP=? and clientId=? and state='0' limit 1";
		String ip=context.getConnection().getRemoteAddress();//remoteAddress的形式如：tcp://127.0.0.1: 6572
		String[] split = ip.split(":");
		String ips=split[1];
		String clientID=context.getClientId();
		String realIp=ips.substring(2, ips.length());
		log.info("time ============== "+ new SimpleDateFormat("yyyy-MM-dd HH:dd:ss.S").format(new Date()));
		log.info("Connecting from ip address " + realIp);
		log.info("Connecting from clientId " + clientID);
		log.info("sql " +sql);
		try {
			User user = JdbcTemplate.queryForObject(sql, new Object[]{realIp,clientID},new BeanPropertyRowMapper<User>(User.class));
			if(user == null){
				throw new SecurityException("Connecting from IP address " + realIp + " is not allowed");
			}
			if(user!=null){
				super.addConnection(context, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("exception "+ e.getMessage());
			throw new SecurityException("Connecting from IP address " + realIp + " is not allowed");
		}
	}

	

	
	
	/*public static void main(String[] args) {
		
		String remoteAddress = "127.12.13.233";
		String clientId="123456";
		Connection connection = DBUtil.getConnection();
		String sql="SELECT id FROM devcenter_amq_verification WHERE ip=?";
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, remoteAddress);
			ResultSet query = statement.executeQuery();
			Integer num=0;
			while(query.next()){
				num++;
			}
			if(num == 1){
				
			}else{
				throw new SecurityException("Connecting from IP address " + remoteAddress + " is not allowed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SecurityException("Connecting from IP address " + remoteAddress + " is not allowed");
		}finally {
			try {
				DBUtil.close(statement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
	}*/
	
}
