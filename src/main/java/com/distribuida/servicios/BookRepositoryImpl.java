package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext(unitName = "BooksPU")
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll",Book.class).getResultList();
    }

    @Override
    public Book findById(Integer id) {
        Book book = em.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book bookAux = em.find(Book.class, book.getId());
        if (bookAux != null){
            em.merge(book);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Book bookDel = em.find(Book.class, id);
        if (bookDel != null){
            em.remove(bookDel);
        }
    }
}
