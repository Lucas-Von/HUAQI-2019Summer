package financial_management.service.user;


import financial_management.bl.product.ProductService4User;
import financial_management.bl.user.UserService;
import financial_management.data.user.UserMapper;
import financial_management.entity.ArticlePO;
import financial_management.entity.UserPO;
import financial_management.parameter.user.UserEmailParam;
import financial_management.parameter.user.UserLoginParam;
import financial_management.parameter.user.UserParam;
import financial_management.parameter.user.UserPasswordParam;
import financial_management.service.article.ArticleServiceForBl;
import financial_management.service.article.collection.CollectionServiceForBl;
import financial_management.util.JwtUtil;
import financial_management.util.SendEmail;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.user.UserSimpleInfoVO;
import financial_management.vo.user.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService4User productService4User;

    @Override
    public BasicResponse register(UserParam userParam){
        try {
            int wrongStatus = 0;
            String email = userParam.getEmail();
            String identityNum = userParam.getIdentityNum();
            if (userMapper.ifExistEmail(email)) {
                wrongStatus = 1;
            }
            if (userMapper.ifExistIdentityNum(identityNum)) {
                if (wrongStatus == 0) {
                    wrongStatus = 2;
                } else {
                    wrongStatus = 3;
                }
            }
            if (wrongStatus == 0) {
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

                SendEmail.send(email, "账号激活邮件", sb.toString());

                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                if (wrongStatus == 1) {
                    return new BasicResponse(ResponseStatus.STATUS_EMAIL_EXIST);
                } else if (wrongStatus == 2) {
                    return new BasicResponse(ResponseStatus.STATUS_IDENTITY_EXIST);
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_EMAIL_AND_IDENTITY_EXIST);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse loginByEmail(UserLoginParam userLoginParam){
        try {
            UserPO userPO = userMapper.selectUserByEmail(userLoginParam.getEmail());
            String password = getCryptPassword(userLoginParam.getPassword());
            if (userPO.getPassword().equals(password)) {
                UsernameVO usernameVO = new UsernameVO();
                usernameVO.setUsername(userPO.getUsername());
                usernameVO.setToken(jwtUtil.generateToken(userPO.getUserId() + ""));
                usernameVO.setProfilePhoto(userPO.getProfilePhoto());
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, usernameVO);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_PASSWORD_WRONG);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updateUsername(String username, Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                userMapper.updateUsername(userId, username);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updateEmail(UserEmailParam userEmailParam){
        try {
            if (userMapper.ifExistEmail(userEmailParam.getOldEmail())) {
                if (!userMapper.ifExistEmail(userEmailParam.getNewEmail())) {
                    userMapper.updateEmail(userEmailParam.getOldEmail(), userEmailParam.getNewEmail());
                    userMapper.changeStatusInIfChangedEmail(userEmailParam.getOldEmail(), 2);
                    return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_EMAIL_EXIST);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updatePhoneNum(String phoneNum, Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                userMapper.updatePhoneNum(userId, phoneNum);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updatePasswordByUserId(String password, Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                password = getCryptPassword(password);
                userMapper.updatePasswordByUserId(userId, password);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updatePasswordByEmail(UserPasswordParam userPasswordParam){
        try {
            if (userMapper.ifExistEmail(userPasswordParam.getEmail())) {
                String password = getCryptPassword(userPasswordParam.getPassword());
                userMapper.updatePasswordByEmail(userPasswordParam.getEmail(), password);
                userMapper.changeStatusInIfChangedPassword(userPasswordParam.getEmail(), 2);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse applyForUpdateEmail(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                // 发送邮件
                StringBuffer sb = new StringBuffer("点击下面链接修改邮箱，链接只能使用一次，请尽快完成操作！</br>");
                sb.append("<a href=\"http://localhost:8080/changeEmail/");
                sb.append(email);
                sb.append("\">http://localhost:8080/changeEmail/");
                sb.append(email);
                sb.append("</a>");

                SendEmail.send(email, "修改绑定邮箱邮件", sb.toString());

                if (!userMapper.ifExistChangedEmail(email)) {
                    userMapper.insertIfChangedEmail(email);
                } else {
                    userMapper.changeStatusInIfChangedEmail(email, 1);
                }

                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse applyForUpdatePassword(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                // 发送邮件
                StringBuffer sb = new StringBuffer("点击下面链接修改密码，链接只能使用一次，请尽快完成操作！</br>");
                sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
                sb.append(email);
                sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
                sb.append(email);
                sb.append("</a>");

                if (!userMapper.ifExistChangedPassword(email)) {
                    userMapper.insertIfChangedPassword(email);
                } else {
                    userMapper.changeStatusInIfChangedPassword(email, 1);
                }

                SendEmail.send(email, "修改密码邮件", sb.toString());

                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getSimpleUser(Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                UserPO userPO = userMapper.selectSimpleUser(userId);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getAllUsers(){
        try {
            List<UserPO> userPOList = userMapper.selectAllUsers();
            List<UserSimpleInfoVO> userVOList = new ArrayList<>();
            for (int i = 0; i < userPOList.size(); i++) {
                userVOList.add(userPOList.get(i).getUserSimpleInfoVO());
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userVOList);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getCollections(Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                List<Long> articleIds = collectionServiceForBl.getCollections(userId);
                List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
                for (int i = 0; i < articleIds.size(); i++) {
                    ArticlePO articlePO = articleServiceForBl.getArticle(articleIds.get(i));
                    ArticleSimpleInfoVO articleSimpleInfoVO = articlePO.getArticleSimpleInfoVO();
                    articleSimpleInfoVO.setCollected(true);

                    articleSimpleInfoVOS.add(articleSimpleInfoVO);
                }
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse activate(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                UserPO userPO = userMapper.selectUserByEmail(email);
                if (userPO.getStatus() == 0) {
                    userMapper.updateStatus(userPO.getUserId(), 1);
                    productService4User.generateFund(userPO.getUserId());
                    return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_ACCOUNT_ACTIVATED);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updateProfilePhoto(String profilePhoto, Long userId){
        try {
            if (userMapper.ifExist(userId)) {
                userMapper.updateProfilePhoto(userId, profilePhoto);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchUserByEmail(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                UserPO userPO = userMapper.selectUserByEmail(email);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchUserByIdentityNum(String identityNum){
        try {
            if (userMapper.ifExistIdentityNum(identityNum)) {
                UserPO userPO = userMapper.selectUserByIdentityNum(identityNum);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchUserByUsername(String username){
        try {
            List<UserPO> userPOList = userMapper.selectUserByUsername(username);
            if (userPOList.size() != 0) {
                List<UserSimpleInfoVO> userSimpleInfoVOS = new ArrayList<>();
                for (int i = 0; i < userPOList.size(); i++) {
                    userSimpleInfoVOS.add(userPOList.get(i).getUserSimpleInfoVO());
                }
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userSimpleInfoVOS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getUserAmount(){
        try {
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userMapper.getUserAmount());
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse ifChangedEmail(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                if (userMapper.ifExistChangedEmail(email)) {
                    int status = userMapper.ifChangedEmail(email);
                    if (status == 1) {
                        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                    } else if (status == 2) {
                        return new BasicResponse(ResponseStatus.STATUS_HAS_CHANGED);
                    } else {
                        return new BasicResponse(ResponseStatus.STATUS_TIME_OUT);
                    }
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_INVALID_LINK);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse ifChangedPassword(String email){
        try {
            if (userMapper.ifExistEmail(email)) {
                if (userMapper.ifExistChangedPassword(email)) {
                    int status = userMapper.ifChangedPassword(email);
                    if (status == 1) {
                        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                    } else if (status == 2) {
                        return new BasicResponse(ResponseStatus.STATUS_HAS_CHANGED);
                    } else {
                        return new BasicResponse(ResponseStatus.STATUS_TIME_OUT);
                    }
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_INVALID_LINK);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
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

    /**
     * 获得加密后的密码
     * @param password
     * @return
     */
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
