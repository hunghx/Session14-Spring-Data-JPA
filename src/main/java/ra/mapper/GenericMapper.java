package ra.mapper;

public interface GenericMapper<R, E, V> {
    /*
     * R: DTO Request Data
     * E: Entity
     * V: DTO Response Data
     * 1. Request DTO --> entity
     * 2. entity --> Response DTO
     * */
    E mapperRequestToEntity(R r);

    V mapperEntityToResponse(E e);

}
