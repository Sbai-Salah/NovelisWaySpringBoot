package io.novelis.springbootnovelisstyle2.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.novelis.springbootnovelisstyle2.dao.repository.ProductRepository;
import io.novelis.springbootnovelisstyle2.domain.Product;
import io.novelis.springbootnovelisstyle2.domain.QProduct;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductDao {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    public Optional<Product> getById(Long id){
        // QueryDSL syntax
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;
        Product product = jpaQueryFactory.selectFrom(qProduct).where(qProduct.id.eq(id)).fetchOne();
        return Optional.ofNullable(product);
    }

    public List<Product> findAll(Pageable pageable)
    {
        JPAQueryFactory jpaQueryFactory=new JPAQueryFactory(entityManager);
        QProduct qProduct=QProduct.product;
        return jpaQueryFactory.selectFrom(qProduct)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }


//    public void delete(Long id){
//        JPAQueryFactory jpaQueryFactory=new JPAQueryFactory(entityManager);
//        QProduct qProduct=QProduct.product;
//        jpaQueryFactory.delete(qProduct).where(qProduct.id.eq(id)).execute();
//    }
    public void save(Product product){
        productRepository.save(product);
    }

}
