package JavaSE08_2.DAO;

import java.util.List;

interface DAOFactory<E, K> {
    List<E> getAll();
    E getEntity(K id);
    E update(K entity);
    void delete(K id);
    void create(E entity);
}