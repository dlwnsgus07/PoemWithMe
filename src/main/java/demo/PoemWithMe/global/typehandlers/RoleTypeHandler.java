package demo.PoemWithMe.global.typehandlers;

import demo.PoemWithMe.domain.member.Role;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Role.class)
public class RoleTypeHandler implements TypeHandler<Role> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public Role getResult(ResultSet rs, String columnName) throws SQLException {
        int roleKey = rs.getInt(columnName);
        return getRole(roleKey);
    }

    @Override
    public Role getResult(ResultSet rs, int columnIndex) throws SQLException {
        int roleKey = rs.getInt(columnIndex);
        return getRole(roleKey);
    }

    @Override
    public Role getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int roleKey = cs.getInt(columnIndex);
        return getRole(roleKey);
    }

    private Role getRole(int roleKey) {
        return switch (roleKey) {
            case 1 -> Role.WRITER;
            case 2 -> Role.PUBLISHER;
            case 3 -> Role.VIP;
            case 4 -> Role.ADMIN;
            default -> null;
        };
    }
}

