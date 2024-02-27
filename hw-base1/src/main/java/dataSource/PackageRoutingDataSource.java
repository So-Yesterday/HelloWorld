package dataSource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class PackageRoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    private Map<String, DruidDataSource> druidDataSourceMap;

    @Override
    public Connection getConnection() throws SQLException {

        Object key = determineCurrentLookupKey();

        DruidDataSource druidDataSource = druidDataSourceMap.get(key);

        return druidDataSource.getConnection();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String key = DataSourceHolder.get();
        if (StringUtils.isBlank(key)) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();

                //load className
            }
        }
        return null;
    }
}
