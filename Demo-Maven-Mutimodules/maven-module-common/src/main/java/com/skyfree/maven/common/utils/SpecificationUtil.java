package com.skyfree.maven.common.utils;
//package com.bfd.dyon.common.utils;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import org.springframework.data.jpa.domain.Specification;
//
//
//public class SpecificationUtil {
//
//    /**
//     * @description 动态生成条件查询中的查询条件
//     * @time 创建时间:2017年9月25日下午5:23:26
//     * @param t 参数类
//     * @return
//     * @author qyf
//     */
//    public static <T> Specification<T> getSpecification(T t) {
//        Specification<T> specification = new Specification<T>() {
//
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicates = new ArrayList<>();
//                Field[] fields = t.getClass().getDeclaredFields();
//                for (Field field : fields) {
//                    field.setAccessible(true);
//                    Object value = null;
//                    try {
//                        value = field.get(t);
//                    } catch (IllegalArgumentException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                    
//                    if (null != value) {
//                        predicates.add(cb.equal(root.get(field.getName()), value));
//                    }
//                }
//                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//            }
//            
//        };
//        return specification;
//    }
//}
