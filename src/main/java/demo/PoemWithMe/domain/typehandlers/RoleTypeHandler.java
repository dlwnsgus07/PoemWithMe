package demo.PoemWithMe.domain.typehandlers;

import demo.PoemWithMe.domain.member.ROLE;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(ROLE.class)
public class RoleTypeHandler implements TypeHandler<ROLE> {
    @Override
    public void setParameter(PreparedStatement ps, int i, ROLE parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public ROLE getResult(ResultSet rs, String columnName) throws SQLException {
        int roleKey = rs.getInt(columnName);
        return getRole(roleKey);
    }

    @Override
    public ROLE getResult(ResultSet rs, int columnIndex) throws SQLException {
        int roleKey = rs.getInt(columnIndex);
        return getRole(roleKey);
    }

    @Override
    public ROLE getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int roleKey = cs.getInt(columnIndex);
        return getRole(roleKey);
    }

    private ROLE getRole(int roleKey) {
        return switch (roleKey) {
            case 1 -> ROLE.WRITER;
            case 2 -> ROLE.PUBLISHER;
            case 3 -> ROLE.VIP;
            case 4 -> ROLE.ADMIN;
            default -> null;
        };
    }
}

