package com.sci.dao;

import com.sci.models.Job_History;
import com.sci.criteria.FilterQuery;
import com.sci.criteria.Operator;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DBJob_History {


    public List<Job_History> get() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.createQuery("FROM Job_History ", Job_History.class).list();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Job_History getById(String jobId) {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.get(Job_History.class, jobId);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }


    public String insert(Job_History job) {

        Transaction transaction = null;
        String jobId = String.valueOf(0);

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            jobId = (String) session.save(jobId);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return jobId;
    }


    public void update(Job_History job) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(job);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(String jobId) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Job_History job = getById(jobId);

            session.delete(job);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public List<Job_History> getByFilter(List<FilterQuery> filterQueries) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Job_History> cr = cb.createQuery(Job_History.class);
            Root<Job_History> root = cr.from(Job_History.class);

            Predicate[] predicates = new Predicate[filterQueries.size()];
            for (int i = 0; i < filterQueries.size(); i++) {
                if (filterQueries.get(i).getOp() == Operator.EQ) {
                    predicates[i] = cb.equal(root.get(filterQueries.get(i).getAttributeName()),
                            filterQueries.get(i).getAttributeValue());
                } else if (filterQueries.get(i).getOp() == Operator.GT) {
                    predicates[i] = cb.gt(root.get(filterQueries.get(i).getAttributeName()),
                            (Integer) filterQueries.get(i).getAttributeValue());
                }
            }
            cr.select(root).where(predicates);


            Query<Job_History> query = session.createQuery(cr);
            return query.getResultList();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return new ArrayList<>();
    }
}


