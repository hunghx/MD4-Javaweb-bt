package ra.mvc.service;

import ra.mvc.dao.AccountDaoImpl;
import ra.mvc.dao.IAccountDao;
import ra.mvc.model.Account;

public class AccountServiceImpl implements IAccountService{
    private  static Account userLogin = null;
    private IAccountDao accountDao = new AccountDaoImpl();
    @Override
    public Account login(String username, String password) {
       // b1 : gọi login của dao
        Account user = accountDao.login(username,password);
        if(user!=null){
            userLogin = user;
            return user;
        }else{
            throw  new RuntimeException("Sai thong tin dang nhap");
        }
    }
    public Account getUserLogin(){
        return userLogin;
    }

    @Override
    public void sendMoney( int idReceiver, int amount) {
        // gọi sang dao để thục hienj chuyen tien
        try {
            accountDao.sendMoney(userLogin.getId(), idReceiver, amount);
            userLogin.setBalance(userLogin.getBalance()-amount);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
