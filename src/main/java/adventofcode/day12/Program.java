package adventofcode.day12;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class Program {

    private final Integer id;
    private List<Program> connections = newArrayList();

    public Program(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void addConnections(Program connection) {
        this.connections.add(connection);
    }

    public List<Program> getConnections() {
        return connections;
    }

    public boolean connectsTo(Integer idToConnectTo) {
        return connectsTo(idToConnectTo, newArrayList());
    }

    private boolean connectsTo(Integer idToConnectTo, List<Integer> toExclude) {
        return connections.stream()
                .anyMatch(connection -> {
                    if (connection.getId().equals(idToConnectTo)) {
                        return true;
                    } else if (toExclude.contains(connection.getId())) {
                        return false;
                    } else {
                        toExclude.add(connection.getId());
                        return connection.connectsTo(idToConnectTo, toExclude);
                    }
                });
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
