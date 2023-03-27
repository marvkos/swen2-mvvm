package at.technikum.mvvm.repository;

import at.technikum.mvvm.data.HibernateSessionFactory;
import at.technikum.mvvm.event.Event;
import at.technikum.mvvm.event.EventAggregator;
import at.technikum.mvvm.model.Word;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.List;

public class WordRepository {

    private final HibernateSessionFactory sessionFactory;
    private final EventAggregator eventAggregator;

    public WordRepository(
            HibernateSessionFactory sessionFactory,
            EventAggregator eventAggregator
    ) {
        this.sessionFactory = sessionFactory;
        this.eventAggregator = eventAggregator;
    }


    public void save(Word word) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(word);
            session.getTransaction().commit();
        }

        eventAggregator.publish(Event.NEW_WORD);
    }

    public List<Word> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Word> criteria = builder.createQuery(Word.class);
            criteria.from(Word.class);

            return session.createQuery(criteria).getResultList();
        }
    }
}
