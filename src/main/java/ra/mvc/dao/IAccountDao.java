package ra.mvc.dao;

import ra.mvc.model.Account;

public interface IAccountDao {
    Account login(String username, String password);
    void sendMoney(int idSender, int idReceiver, int amount);
}
