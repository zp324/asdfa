package cn.smbms.service.user;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		user = userMapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

}
