package financial_management.service.user;

import financial_management.bl.user.UserService;
import financial_management.data.user.UserMapper;
import financial_management.entity.ArticlePO;
import financial_management.entity.UserPO;
import financial_management.parameter.*;
import financial_management.service.article.ArticleServiceForBl;
import financial_management.service.article.collection.CollectionServiceForBl;
import financial_management.util.JwtUtil;
import financial_management.util.SendEmail;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;
import financial_management.vo.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
@Service
public class UserServiceImpl implements UserService, UserServiceForBl {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CollectionServiceForBl collectionServiceForBl;
    @Autowired
    private ArticleServiceForBl articleServiceForBl;

    @Override
    public ResponseEntity<String> register(UserParam userParam){
        String error = "";
        String email = userParam.getEmail();
        String identityNum = userParam.getIdentityNum();
        if(userMapper.ifExistEmail(email)){
            error = "该邮箱已被注册！";
        }
        if(userMapper.ifExistIdentityNum(identityNum)){
            if(error.equals("")){
                error = "该身份证号已被绑定！";
            }else {
                error = error + "；该身份证号已被绑定！";
            }
        }
        if(error.equals("")){
            UserPO userPO = userParam.getUserPo();
            userPO.setPassword(getCryptPassword(userPO.getPassword()));
            userMapper.insert(userPO);

            // 发送邮件
            StringBuffer sb = new StringBuffer("点击下面链接激活账号，10分钟内生效，否则需要重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
            sb.append(email);
            sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
            sb.append(email);
            sb.append("</a>");

            SendEmail.send(email,"账号激活邮件", sb.toString());

            return ResponseEntity.ok().body("注册成功！");
        }else {
            return ResponseEntity.status(403).body(error);
        }
    }

    @Override
    public ResponseEntity<UsernameVO> loginByEmail(UserLoginParam userLoginParam){
        UserPO userPO = userMapper.selectUserByEmail(userLoginParam.getEmail());
        String password = getCryptPassword(userLoginParam.getPassword());
        if(userPO.getPassword().equals(password)){
            UsernameVO usernameVO = new UsernameVO();
            usernameVO.setUsername(userPO.getUsername());
            usernameVO.setToken(jwtUtil.generateToken(userPO.getUserId()+""));
            usernameVO.setProfilePhoto(userPO.getProfilePhoto());
            return ResponseEntity.ok().body(usernameVO);
        }else {
            return ResponseEntity.status(403).build();
        }
    }

    @Override
    public ResponseEntity<String> updateUsername(String username, Long userId){
        if(userMapper.ifExist(userId)) {
            userMapper.updateUsername(userId, username);
            return ResponseEntity.ok().body("更新用户昵称成功！");
        }else {
            return ResponseEntity.status(403).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updateEmail(UserEmailParam userEmailParam){
        if(userMapper.ifExistEmail(userEmailParam.getOldEmail())) {
            if(!userMapper.ifExistEmail(userEmailParam.getNewEmail())) {
                userMapper.updateEmail(userEmailParam.getOldEmail(), userEmailParam.getNewEmail());
                return ResponseEntity.ok().body("更新用户邮箱成功！");
            }else {
                return ResponseEntity.status(403).body("该邮箱已被注册！");
            }
        }else {
            return ResponseEntity.status(403).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updatePhoneNum(String phoneNum, Long userId){
        if(userMapper.ifExist(userId)) {
            userMapper.updatePhoneNum(userId, phoneNum);
            return ResponseEntity.ok().body("更新用户手机号成功！");
        }else {
            return ResponseEntity.status(403).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updatePasswordByUserId(String password, Long userId){
        if(userMapper.ifExist(userId)) {
            password = getCryptPassword(password);
            userMapper.updatePasswordByUserId(userId, password);
            return ResponseEntity.ok().body("更新用户密码成功！");
        }else {
            return ResponseEntity.status(403).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updatePasswordByEmail(UserPasswordParam userPasswordParam){
        if(userMapper.ifExistEmail(userPasswordParam.getEmail())){
            String password = getCryptPassword(userPasswordParam.getPassword());
            userMapper.updatePasswordByEmail(userPasswordParam.getEmail(),password);
            return ResponseEntity.ok().body("更新用户密码成功！");
        }else {
            return ResponseEntity.status(403).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> applyForUpdateEmail(String email){
        // 发送邮件
        StringBuffer sb = new StringBuffer("点击下面链接修改邮箱，链接只能使用一次，请尽快完成操作！</br>");
        sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
        sb.append(email);
        sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
        sb.append(email);
        sb.append("</a>");

        SendEmail.send(email, "修改绑定邮箱邮件", sb.toString());

        return ResponseEntity.ok().body("请尽快点击链接完成修改邮箱操作！");
    }

    @Override
    public ResponseEntity<String> applyForUpdatePassword(String email){
        // 发送邮件
        StringBuffer sb = new StringBuffer("点击下面链接修改密码，链接只能使用一次，请尽快完成操作！</br>");
        sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
        sb.append(email);
        sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
        sb.append(email);
        sb.append("</a>");

        SendEmail.send(email,"修改密码邮件", sb.toString());

        return ResponseEntity.ok().body("请尽快点击链接完成修改密码操作！");
    }

    @Override
    public ResponseEntity<UserVO> getSimpleUser(Long userId){
        if(userMapper.ifExist(userId)) {
            UserPO userPO = userMapper.selectSimpleUser(userId);
            return ResponseEntity.ok().body(userPO.getUserVO());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<UserSimpleInfoVO>> getAllUsers(){
        List<UserPO> userPOList = userMapper.selectAllUsers();
        List<UserSimpleInfoVO> userVOList = new ArrayList<>();
        for(int i=0;i<userPOList.size();i++){
            userVOList.add(userPOList.get(i).getUserSimpleInfoVO());
        }
        return ResponseEntity.ok().body(userVOList);
    }

    @Override
    public ResponseEntity<List<ArticleSimpleInfoVO>> getCollections(Long userId){
        if(userMapper.ifExist(userId)) {
            List<Long> articleIds = collectionServiceForBl.getCollections(userId);
            List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
            for (int i = 0; i < articleIds.size(); i++) {
                ArticleSimpleInfoVO articleSimpleInfoVO = new ArticleSimpleInfoVO();
                ArticlePO articlePO = articleServiceForBl.getArticle(articleIds.get(i));

                articleSimpleInfoVO.setArticleId(articlePO.getArticleId());
                articleSimpleInfoVO.setSummary(articlePO.getSummary());
                articleSimpleInfoVO.setTitle(articlePO.getTitle());
                articleSimpleInfoVO.setCollected(true);

                articleSimpleInfoVOS.add(articleSimpleInfoVO);
            }
            return ResponseEntity.ok().body(articleSimpleInfoVOS);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> activate(String email){
        if(userMapper.ifExistEmail(email)) {
            UserPO userPO = userMapper.selectUserByEmail(email);
            if(userPO.getStatus() == 0) {
                userMapper.updateStatus(userPO.getUserId(), 1);
                return ResponseEntity.ok().body("账号已成功激活！");
            }else {
                return ResponseEntity.status(403).body("您的账号已经被激活，请勿重复操作！");
            }
        }else {
            return ResponseEntity.status(403).body("该邮箱不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updateProfilePhoto(String profilePhoto, Long userId){
        if(userMapper.ifExist(userId)) {
            userMapper.updateProfilePhoto(userId, profilePhoto);
            return ResponseEntity.ok().body("更新用户头像成功！");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserVO> searchUserByEmail(String email){
        if(userMapper.ifExistEmail(email)) {
            UserPO userPO = userMapper.selectUserByEmail(email);
            return ResponseEntity.ok().body(userPO.getUserVO());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserVO> searchUserByIdentityNum(String identityNum){
        if(userMapper.ifExistIdentityNum(identityNum)){
            UserPO userPO = userMapper.selectUserByIdentityNum(identityNum);
            return ResponseEntity.ok().body(userPO.getUserVO());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<UserSimpleInfoVO>> searchUserByUsername(String username){
        List<UserPO> userPOList = userMapper.selectUserByUsername(username);
        if(userPOList.size() != 0){
            List<UserSimpleInfoVO> userSimpleInfoVOS = new ArrayList<>();
            for(int i=0;i<userPOList.size();i++){
                userSimpleInfoVOS.add(userPOList.get(i).getUserSimpleInfoVO());
            }
            return ResponseEntity.ok().body(userSimpleInfoVOS);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public String getUsername(Long userId){
        if(userMapper.ifExist(userId)) {
            UserPO userPO = userMapper.selectSimpleUser(userId);
            return userPO.getUsername();
        }else {
            return "该用户已被注销";
        }
    }

    private String getCryptPassword(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(password.getBytes());
            byte[] bytebuffer = messageDigest.digest();
            StringBuilder strHexString = new StringBuilder();
            for (int i = 0; i < bytebuffer.length; i ++){
                String hex = Integer.toHexString(0xff & bytebuffer[i]);
                if (hex.length() == 1){
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            password = strHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
