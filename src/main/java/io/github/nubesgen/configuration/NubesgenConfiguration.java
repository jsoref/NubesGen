package io.github.nubesgen.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class NubesgenConfiguration {

    private String location;

    private String applicationName;

    @JsonProperty("database")
    private DatabaseConfiguration databaseConfiguration;

    @JsonProperty("addOns")
    private List<AddOnConfiguration> addOns = new ArrayList<>();

    public NubesgenConfiguration() {
        this.location = "eastus";
        this.applicationName = "sampleNubesApplication";
        this.databaseConfiguration = new DatabaseConfiguration();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    public List<AddOnConfiguration> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOnConfiguration> addOns) {
        this.addOns = addOns;
    }

    public boolean isDatabaseTypeNone() {
        return DatabaseType.NONE.equals(this.databaseConfiguration.getDatabaseType());
    }

    public boolean isDatabaseTypeMysql() {
        return DatabaseType.MYSQL.equals(this.databaseConfiguration.getDatabaseType());
    }

    public boolean isDatabaseTypePostgresql() {
        return DatabaseType.POSTGRESQL.equals(this.databaseConfiguration.getDatabaseType());
    }

    public boolean isAddOnStorageBlob() {
        return this.getAddOns().stream()
                .anyMatch(addOn -> AddOnType.STORAGE_BLOB.equals(addOn.getAddOnType()));
    }

    @Override
    public String toString() {
        return "NubesgenConfiguration{" +
                "location='" + location + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", databaseConfiguration=" + databaseConfiguration +
                ", addOns=" + addOns +
                '}';
    }
}