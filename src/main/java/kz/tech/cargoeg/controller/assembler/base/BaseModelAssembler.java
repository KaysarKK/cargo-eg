package kz.tech.cargoeg.controller.assembler.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public abstract class BaseModelAssembler<T, D extends RepresentationModel<D>> extends RepresentationModelAssemblerSupport<T, D> {


    @Autowired
    HttpServletRequest request;


    public BaseModelAssembler(Class<?> controllerClass, Class<D> resourceType) {

        super(controllerClass, resourceType);
    }

    public PagedModel<D> toPagedModel(Page<T> entityPage) {
        final CollectionModel resources = toCollectionModel(entityPage);
        return PagedModel.of(resources.getContent(), new PagedModel.PageMetadata(entityPage.getSize(),
                entityPage.getNumber(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages()), resources.getLinks());
    }


    @Override
    public D toModel(T entity) {

        return null;
    }

    protected String buildUrl(String serviceName, String url) {
        return String.format("%s://%s/%s%s", request.getScheme(), request.getHeader("Host"), serviceName, url);
    }

}
