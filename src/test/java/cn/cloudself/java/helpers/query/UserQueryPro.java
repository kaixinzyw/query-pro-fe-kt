package cn.cloudself.java.helpers.query;

import cn.cloudself.java.helpers.query.User;
import cn.cloudself.query.*;
import cn.cloudself.query.exception.IllegalCall;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class UserQueryPro {
    private static QueryStructure defQueryStructure() {
        final QueryStructure queryStructure = new QueryStructure();
        queryStructure.setFrom(new QueryStructureFrom(__Impl.TABLE_NAME, new ArrayList<>()));
        return queryStructure;
    }

    private static QueryPro<
            User,
            __Impl.WhereField<User, List<User>>,
            __Impl.OrderByField<User, List<User>>,
            __Impl.UpdateSetField,
            __Impl.WhereField<Boolean, Boolean>,
            __Impl.WhereField<Boolean, Boolean>
    > createQuery(QueryStructure queryStructure) {
        return new QueryPro<>(
                User.class,
                queryStructure, 
                qs -> new __Impl.WhereField<>(qs, User.class),
                qs -> new __Impl.OrderByField<>(qs, User.class),
                __Impl.UpdateSetField::new,
                qs -> new __Impl.WhereField<>(qs, Boolean.class),
                qs -> new __Impl.WhereField<>(qs, Boolean.class)
        );
    }

    private static final QueryPro<
            User,
            __Impl.WhereField<User, List<User>>,
            __Impl.OrderByField<User, List<User>>,
            __Impl.UpdateSetField,
            __Impl.WhereField<Boolean, Boolean>,
            __Impl.WhereField<Boolean, Boolean>
    > queryPro = createQuery(defQueryStructure());

    public static final QueryProEx<
            QueryPro<
                    User,
                    __Impl.WhereField<User, List<User>>,
                    __Impl.OrderByField<User, List<User>>,
                    __Impl.UpdateSetField,
                    __Impl.WhereField<Boolean, Boolean>,
                    __Impl.WhereField<Boolean, Boolean>
            >,
            __Impl.WhereField<User, List<User>>,
            __Impl.FieldsGenerator
    > EX = new QueryProEx<>(
            defQueryStructure(),
            qs -> new __Impl.WhereField<>(qs, User.class),
            __Impl.FieldsGenerator::new,
            UserQueryPro::createQuery
    );

    public static __Impl.WhereField<Boolean, Boolean> deleteBy() {
        return queryPro.deleteBy();
    }

    public static boolean deleteByPrimaryKey(Object keyValue) {
        return queryPro.deleteByPrimaryKey(keyValue);
    }

    public static Object insert(User obj) {
        return queryPro.insert(obj);
    }

    public static java.util.List<Object> insert(User ...objs) {
        return queryPro.insert(objs);
    }

    public static java.util.List<Object> insert(java.util.Collection<User> collection) {
        return queryPro.insert(collection);
    }

    public static __Impl.OrderByField<User, List<User>> orderBy() {
        return queryPro.orderBy();
    }

    public static __Impl.WhereField<User, List<User>> selectBy() {
        return queryPro.selectBy();
    }

    public static __Impl.UpdateSetField updateSet() {
        return queryPro.updateSet();
    }

    public static UpdateField<__Impl.WhereField<Boolean, Boolean>> updateSet(User obj, boolean override) {
        return queryPro.updateSet(obj, override);
    }

    public static class __Impl {
        private static final Class<User> CLAZZ = User.class;
        public static final String TABLE_NAME = "user";
        private static Field createField(String column) { return new Field(TABLE_NAME, column, null); }

        public abstract static class CommonField<T, RUN_RES>
                extends QueryField<T, RUN_RES, WhereField<T, RUN_RES>, OrderByField<T, RUN_RES>, ColumnLimiterField<T, RUN_RES>, ColumnsLimiterField<T, RUN_RES>> {
            public CommonField(QueryStructure queryStructure, Class<T> field_clazz) { super(queryStructure, field_clazz); }

            @NotNull
            @Override
            protected Function1<QueryStructure, WhereField<T, RUN_RES>> getCreate_where_field() { return qs -> new WhereField<>(qs, super.getField_clazz()); }

            @NotNull
            @Override
            protected Function1<QueryStructure, OrderByField<T, RUN_RES>> getCreate_order_by_field() { return qs -> new OrderByField<>(qs, super.getField_clazz()); }

            @NotNull
            @Override
            protected Function1<QueryStructure, ColumnLimiterField<T, RUN_RES>> getCreate_column_limiter_field() { return qs -> new ColumnLimiterField<>(qs, super.getField_clazz()); }

            @NotNull
            @Override
            protected Function1<QueryStructure, ColumnsLimiterField<T, RUN_RES>> getCreate_columns_limiter_field() { return qs -> new ColumnsLimiterField<>(qs, super.getField_clazz()); }
        }

        public static class WhereField<T, RUN_RES> extends CommonField<T, RUN_RES> {
            public WhereField(QueryStructure queryStructure, Class<T> field_clazz) { super(queryStructure, field_clazz); }

            @NotNull
            @Override
            protected QueryFieldType getField_type() { return QueryFieldType.WHERE_FIELD; }

            private QueryKeywords<WhereField<T, RUN_RES>> createWhereField(String column) {
                return new QueryKeywords<>(createField(column), super.getQueryStructure(), super.getCreate_where_field());
            }

            public QueryKeywords<WhereField<T, RUN_RES>> id() { return createWhereField("id"); }
            public QueryKeywords<WhereField<T, RUN_RES>> name() { return createWhereField("name"); }
            public QueryKeywords<WhereField<T, RUN_RES>> age() { return createWhereField("age"); }
        }

        public static class OrderByField<T, RUN_RES> extends CommonField<T, RUN_RES> {
            public OrderByField(QueryStructure queryStructure, Class<T> field_clazz) { super(queryStructure, field_clazz); }

            @NotNull
            @Override
            protected QueryFieldType getField_type() { return QueryFieldType.ORDER_BY_FIELD; }

            private QueryOrderByKeywords<OrderByField<T, RUN_RES>> createOrderByField(String column) {
                return new QueryOrderByKeywords<>(createField(column), super.getQueryStructure(), super.getCreate_order_by_field());
            }

            public QueryOrderByKeywords<OrderByField<T, RUN_RES>> id() { return createOrderByField("id"); }
            public QueryOrderByKeywords<OrderByField<T, RUN_RES>> name() { return createOrderByField("name"); }
            public QueryOrderByKeywords<OrderByField<T, RUN_RES>> age() { return createOrderByField("age"); }
        }

        public static class ColumnLimiterField<T, RUN_RES> extends CommonField<T, RUN_RES> {
            public ColumnLimiterField(QueryStructure queryStructure, Class<T> field_clazz) { super(queryStructure, field_clazz); }

            @NotNull
            @Override
            protected QueryFieldType getField_type() { return QueryFieldType.OTHER_FIELD; }

            public List<Long> id() { return super.getColumn(createField("id"), Long.class); }
            public List<String> name() { return super.getColumn(createField("name"), String.class); }
            public List<Integer> age() { return super.getColumn(createField("age"), Integer.class); }
        }

        public static class ColumnsLimiterField<T, RUN_RES> extends CommonField<T, RUN_RES> {
            public ColumnsLimiterField(QueryStructure queryStructure, Class<T> field_clazz) { super(queryStructure, field_clazz); }

            @NotNull
            @Override
            protected QueryFieldType getField_type() { return QueryFieldType.OTHER_FIELD; }

            @SuppressWarnings("DuplicatedCode")
            private ColumnsLimiterField<T, RUN_RES> createColumnsLimiterField(String column) {
                final QueryStructure oldQueryStructure = getQueryStructure();
                final QueryStructure newQueryStructure = oldQueryStructure.copy(
                        oldQueryStructure.getAction(),
                        oldQueryStructure.getUpdate(),
                        new ArrayList<Field>(oldQueryStructure.getFields()) {{
                            add(createField(column));
                        }},
                        oldQueryStructure.getFrom(),
                        oldQueryStructure.getWhere(),
                        oldQueryStructure.getOrderBy(),
                        oldQueryStructure.getLimit()
                );
                return new ColumnsLimiterField<>(newQueryStructure, super.getField_clazz());
            }

            public ColumnsLimiterField<T, RUN_RES> id() { return createColumnsLimiterField("id"); }
            public ColumnsLimiterField<T, RUN_RES> name() { return createColumnsLimiterField("name"); }
            public ColumnsLimiterField<T, RUN_RES> age() { return createColumnsLimiterField("age"); }
        }

        public static class UpdateSetField extends UpdateField<WhereField<Boolean, Boolean>> {
            private final QueryStructure queryStructure;
            public UpdateSetField(QueryStructure queryStructure) {
                super(queryStructure, qs -> new WhereField<>(qs, Boolean.class));
                this.queryStructure = queryStructure;
            }

            @SuppressWarnings("DuplicatedCode")
            private UpdateSetField createUpdateSetField(String key, Object value) {
                final Update update = queryStructure.getUpdate();
                if (update == null) {
                    throw new IllegalCall("usage like: UserQueryPro.updateSet().id(1).name(name).run()");
                }
                @SuppressWarnings("unchecked") final Map<String, Object> map = (Map<String, Object>) update.getData();
                assert map != null;
                map.put(key, value);
                return this;
            }

            public UpdateSetField id(Object id) { return createUpdateSetField("id", id); }
            public UpdateSetField name(Object name) { return createUpdateSetField("name", name); }
            public UpdateSetField age(Object age) { return createUpdateSetField("age", age); }
        }

        public static class FieldsGenerator extends FieldGenerator {
            @NotNull
            @Override
            public String getTableName() { return TABLE_NAME; }

            public FieldsGenerator id() { this.getFields().add(createField("id")); return this; }
            public FieldsGenerator name() { this.getFields().add(createField("name")); return this; }
            public FieldsGenerator age() { this.getFields().add(createField("age")); return this; }
        }
    }
}
