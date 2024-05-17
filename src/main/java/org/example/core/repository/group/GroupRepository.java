package org.example.core.repository.group;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.web.model.group.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Repository
public class GroupRepository implements IGroupRepository{

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Group> grouRowMapper;

    public GroupRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.grouRowMapper = (rs, rowNum) -> {
            long groupId = rs.getInt("group_id");
            String groupName = rs.getString("group_name");
            return new Group(groupId, groupName);
        };
    }


    @Override
    public GetGroupResponse getGroup() {

        String sql = "select * from groups";
        return new GetGroupResponse(jdbcOperations.query(sql,grouRowMapper));
    }

    @Override
    public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws EmptyDataException {
        try{
        String sql = "select group_name from groups where group_id=?";
        return new GetGroupByIdResponse(jdbcOperations.queryForObject(sql,grouRowMapper,request.getGroupId()));}
        catch (DataAccessException e) {
            throw new EmptyDataException("Group with id: " + request.getGroupId() + " not found!");
        }

    }

    @Override
    public AddGroupResponse addGroup(AddGroupRequest request) throws EmptyDataException {/////уверен в return?
        try {
            String sql = "insert into groups (group_name) values (?)";
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            PreparedStatementCreator preparedStatementCreator = conn -> {
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"group_id"});
                preparedStatement.setString(1, request.getName());
                return preparedStatement;
            };
            //jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);
            return new AddGroupResponse(jdbcOperations.update(preparedStatementCreator, generatedKeyHolder));
        } catch (DataAccessException e) {
            throw new EmptyDataException("Can't add group with name" + request.getName());
        }
    }

    @Override
    public EditGroupResponse editGroup(EditGroupRequest request) throws EmptyDataException { ////Integer.toString???????
        try {
            String sql = "update groups set group_name = ? where group_id = ?";
            int rowsChanged = jdbcOperations.update(sql, request.getName(), request.getId());
            if (rowsChanged == 0) {
                throw new EmptyDataException("Can't edit group: " + request);
            }
            return new EditGroupResponse(Integer.toString(jdbcOperations.update(sql, request.getName(), request.getId())));
        } catch (DataAccessException e) {
            throw new EmptyDataException("Can't edit group: " + request);
        }
    }

    @Override
    public void deleteGroup(DeleteGroupRequest request) throws EmptyDataException {
        String sql = "delete from groups where group_id = ?";
        int rowsChanged = jdbcOperations.update(sql, request.getId());
        if (rowsChanged == 0) {
            throw new EmptyDataException("Can't delete group with id: " + request.getId());
        }
    }
}