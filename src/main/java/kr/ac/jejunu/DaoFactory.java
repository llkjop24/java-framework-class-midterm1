package kr.ac.jejunu;

public class DaoFactory {
    public ProductDao productDao(){
        return new ProductDao();
    }

    public ConnectionMaker connectionMaker(){
        return new JejuConnectionMaker();
    }
}
