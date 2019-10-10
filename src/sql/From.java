package sql;

import modelandcontext.Context;
import java.util.List;

/**
 *  Uses Builder pattern to provide easily configurable constructors
 */
public class From implements SQLStatement
{

    private final String database;
    private final String table;
    private final Where where;

    public static class Builder
    {
        private String database = null;
        private String table = null;
        private Where where = null;

        public Builder() {}

        public Builder database(String databaseName)
        {
            database = databaseName;
            return this;
        }

        public Builder table(String tableName)
        {
            table = tableName;
            return this;
        }

        public Builder where(Where whereCondition)
        {
            where = whereCondition;
            return this;
        }

        public From build()
        {
            return new From(this);
        }
    }

    private From(Builder builder)
    {
        database = builder.database;
        table = builder.table;
        where = builder.where;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        ctx.setDatabase(database);
        ctx.setTable(table);
        return where.parseAndReturn(ctx);
    }
}

