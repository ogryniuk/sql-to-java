package sql;

import modelandcontext.Context;
import modelandcontext.UserRow;
import java.util.List;
import java.util.function.Predicate;

/**
 *  Uses Builder pattern to provide easily configurable constructors
 */
public class Where implements SQLStatement
{

    private Predicate<UserRow> isCustomerFilter;
    private Predicate<Integer> logIdFilter;

    public static class Builder
    {
        private Predicate<UserRow> isCustomerFilter = null;
        private Predicate<Integer> logIdFilter = null;

        public Builder(){}

        public Builder isCustomer(Predicate<UserRow> customerFilterValue)
        {
            isCustomerFilter = customerFilterValue;
            return this;
        }

        public Builder logID(Predicate<Integer> idValue)
        {
            logIdFilter = idValue;
            return this;
        }

        public Where build()
        {
            return new Where(this);
        }
    }

    private Where(Builder builder)
    {
        isCustomerFilter = builder.isCustomerFilter;
        logIdFilter = builder.logIdFilter;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        ctx.setLogIdFilter(logIdFilter);
        ctx.setCustomerStatusFilter(isCustomerFilter);

        if(logIdFilter != null)
            return ctx.deleteLogs();

        return ctx.select();
    }
}

