package org.tiscs.reststack.core.postgres;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        dateTime = dateTime.withZone(DateTimeZone.UTC);
        ps.setTimestamp(i, new Timestamp(dateTime.getMillis()));
    }

    private DateTime parse(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        else {
            return new DateTime(timestamp.getTime(), DateTimeZone.UTC);
        }
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, String s) throws SQLException {
        return parse((Timestamp) rs.getObject(s));
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, int i) throws SQLException {
        return parse((Timestamp) rs.getObject(i));
    }

    @Override
    public DateTime getNullableResult(CallableStatement cs, int i) throws SQLException {
        return parse((Timestamp) cs.getObject(i));
    }
}
