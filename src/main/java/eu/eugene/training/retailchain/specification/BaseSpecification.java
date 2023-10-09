package eu.deltasource.training.retailchain.specification;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * Defines generic methods for dynamic queries.
 */
public class BaseSpecification {

    /**
     * Searches the given attributes by a search term. Partial string is supported.
     * Return all resources when the search term is empty or null.
     *
     * @param attribute Name of attribute to search in.
     * @param searchTerm Search tem to look for in the attribute. Can be null.
     * @param <T> Type of entity.
     * @return Specification object based on filtering criteria.
     */
    public <T> Specification<T> attributeContains(String attribute, String searchTerm) {
        return (root, query, builder) -> {
            Path<String> attributePath = root.get(attribute);
            if (!StringUtils.hasText(attribute) || !StringUtils.hasText(searchTerm)) {
                return builder.isTrue(builder.literal(true));
            }
            return builder.like(builder.lower(attributePath), "%" + searchTerm.toLowerCase() + "%");
        };
    }
}