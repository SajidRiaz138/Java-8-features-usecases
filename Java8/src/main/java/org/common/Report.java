package org.common;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Report
{
    private final String reportName;
    private final Map<String, Object> data;

    public Report(String reportName, Map<String, Object> data)
    {
        this.reportName = reportName;
        this.data = data;
    }

    public String getReportName()
    {
        return reportName;
    }

    public Map<String, Object> getData()
    {
        return Collections.unmodifiableMap(data);
    }

    @Override
    public String toString()
    {
        return "Report{" +
                "reportName='" + reportName + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(reportName, report.reportName) &&
                Objects.equals(data, report.data);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(reportName, data);
    }
}
