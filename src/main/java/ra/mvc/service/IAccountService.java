package ra.mvc.service;

import ra.mvc.model.Account;

public interface IAccountService {
    Account login(String username, String password);
    void sendMoney(int idReceiver, int amount);
    Account getUserLogin();
}
