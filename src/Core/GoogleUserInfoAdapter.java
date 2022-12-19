package Core;

import JLogger.GoogleUserInfo;

public class GoogleUserInfoAdapter implements GoogleUserInfoService{


    @Override
    public GoogleUserInfo getUserInfo() {
        GoogleUserInfo info = new GoogleUserInfo();
        return info;
    }
}
