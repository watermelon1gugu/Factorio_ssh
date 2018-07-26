package com.ScuSoftware.Factorio.dao;

import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.model.UserExample.Criteria;
import com.ScuSoftware.Factorio.model.UserExample.Criterion;
import com.ScuSoftware.Factorio.model.UserExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String countByExample(UserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=CHAR}");
        }
        
        if (record.getBrithday() != null) {
            sql.VALUES("brithday", "#{brithday,jdbcType=DATE}");
        }
        
        if (record.getEntryDate() != null) {
            sql.VALUES("entry_date", "#{entryDate,jdbcType=DATE}");
        }
        
        if (record.getJob() != null) {
            sql.VALUES("job", "#{job,jdbcType=CHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.VALUES("salary", "#{salary,jdbcType=DOUBLE}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=CHAR}");
        }
        
        if (record.getResume() != null) {
            sql.VALUES("resume", "#{resume,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("username");
        sql.SELECT("brithday");
        sql.SELECT("entry_date");
        sql.SELECT("job");
        sql.SELECT("salary");
        sql.SELECT("image");
        sql.SELECT("resume");
        sql.FROM("user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("username");
        sql.SELECT("brithday");
        sql.SELECT("entry_date");
        sql.SELECT("job");
        sql.SELECT("salary");
        sql.SELECT("image");
        sql.FROM("user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{record.username,jdbcType=CHAR}");
        }
        
        if (record.getBrithday() != null) {
            sql.SET("brithday = #{record.brithday,jdbcType=DATE}");
        }
        
        if (record.getEntryDate() != null) {
            sql.SET("entry_date = #{record.entryDate,jdbcType=DATE}");
        }
        
        if (record.getJob() != null) {
            sql.SET("job = #{record.job,jdbcType=CHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.SET("salary = #{record.salary,jdbcType=DOUBLE}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{record.image,jdbcType=CHAR}");
        }
        
        if (record.getResume() != null) {
            sql.SET("resume = #{record.resume,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("username = #{record.username,jdbcType=CHAR}");
        sql.SET("brithday = #{record.brithday,jdbcType=DATE}");
        sql.SET("entry_date = #{record.entryDate,jdbcType=DATE}");
        sql.SET("job = #{record.job,jdbcType=CHAR}");
        sql.SET("salary = #{record.salary,jdbcType=DOUBLE}");
        sql.SET("image = #{record.image,jdbcType=CHAR}");
        sql.SET("resume = #{record.resume,jdbcType=LONGVARCHAR}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("username = #{record.username,jdbcType=CHAR}");
        sql.SET("brithday = #{record.brithday,jdbcType=DATE}");
        sql.SET("entry_date = #{record.entryDate,jdbcType=DATE}");
        sql.SET("job = #{record.job,jdbcType=CHAR}");
        sql.SET("salary = #{record.salary,jdbcType=DOUBLE}");
        sql.SET("image = #{record.image,jdbcType=CHAR}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=CHAR}");
        }
        
        if (record.getBrithday() != null) {
            sql.SET("brithday = #{brithday,jdbcType=DATE}");
        }
        
        if (record.getEntryDate() != null) {
            sql.SET("entry_date = #{entryDate,jdbcType=DATE}");
        }
        
        if (record.getJob() != null) {
            sql.SET("job = #{job,jdbcType=CHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.SET("salary = #{salary,jdbcType=DOUBLE}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=CHAR}");
        }
        
        if (record.getResume() != null) {
            sql.SET("resume = #{resume,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}