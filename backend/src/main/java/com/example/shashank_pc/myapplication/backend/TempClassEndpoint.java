package com.example.shashank_pc.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Nullable;
import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * WARNING: This generated code is intended as a sample or starting point for using a
 * Google Cloud Endpoints RESTful API with an Objectify entity. It provides no data access
 * restrictions and no data validation.
 * <p>
 * DO NOT deploy this code unchanged as part of a real application to real users.
 */
@Api(
        name = "tempClassApi",
        version = "v1",
        resource = "tempClass",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.shashank_pc.example.com",
                ownerName = "backend.myapplication.shashank_pc.example.com",
                packagePath = ""
        )
)
public class TempClassEndpoint {

    private static final Logger logger = Logger.getLogger(TempClassEndpoint.class.getName());

    private static final int DEFAULT_LIST_LIMIT = 20;

    static {
        // Typically you would register this inside an OfyServive wrapper. See: https://code.google.com/p/objectify-appengine/wiki/BestPractices
        ObjectifyService.register(TempClass.class);
    }

    /**
     * Returns the {@link TempClass} with the corresponding ID.
     *
     * @param ID the ID of the entity to be retrieved
     * @return the entity with the corresponding ID
     * @throws NotFoundException if there is no {@code TempClass} with the provided ID.
     */
    @ApiMethod(
            name = "get",
            path = "tempClass/{ID}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public TempClass get(@Named("ID") String ID) throws NotFoundException {
        logger.info("Getting TempClass with ID: " + ID);
        TempClass tempClass = ofy().load().type(TempClass.class).id(ID).now();
        if (tempClass == null) {
            throw new NotFoundException("Could not find TempClass with ID: " + ID);
        }
        return tempClass;
    }

    /**
     * Inserts a new {@code TempClass}.
     */
    @ApiMethod(
            name = "insert",
            path = "tempClass",
            httpMethod = ApiMethod.HttpMethod.POST)
    public TempClass insert(TempClass tempClass) {
        // Typically in a RESTful API a POST does not have a known ID (assuming the ID is used in the resource path).
        // You should validate that tempClass.ID has not been set. If the ID type is not supported by the
        // Objectify ID generator, e.g. long or String, then you should generate the unique ID yourself prior to saving.
        //
        // If your client provides the ID then you should probably use PUT instead.
        ofy().save().entity(tempClass).now();
        logger.info("Created TempClass with ID: " + tempClass.getID());

        return ofy().load().entity(tempClass).now();
    }

    /**
     * Updates an existing {@code TempClass}.
     *
     * @param ID        the ID of the entity to be updated
     * @param tempClass the desired state of the entity
     * @return the updated version of the entity
     * @throws NotFoundException if the {@code ID} does not correspond to an existing
     *                           {@code TempClass}
     */
    @ApiMethod(
            name = "update",
            path = "tempClass/{ID}",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public TempClass update(@Named("ID") String ID, TempClass tempClass) throws NotFoundException {
        // TODO: You should validate your ID parameter against your resource's ID here.
        checkExists(ID);
        ofy().save().entity(tempClass).now();
        logger.info("Updated TempClass: " + tempClass);
        return ofy().load().entity(tempClass).now();
    }

    /**
     * Deletes the specified {@code TempClass}.
     *
     * @param ID the ID of the entity to delete
     * @throws NotFoundException if the {@code ID} does not correspond to an existing
     *                           {@code TempClass}
     */
    @ApiMethod(
            name = "remove",
            path = "tempClass/{ID}",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public void remove(@Named("ID") String ID) throws NotFoundException {
        checkExists(ID);
        ofy().delete().type(TempClass.class).id(ID).now();
        logger.info("Deleted TempClass with ID: " + ID);
    }

    /**
     * List all entities.
     *
     * @param cursor used for pagination to determine which page to return
     * @param limit  the maximum number of entries to return
     * @return a response that encapsulates the result list and the next page token/cursor
     */
    @ApiMethod(
            name = "list",
            path = "tempClass",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<TempClass> list(@Nullable @Named("cursor") String cursor, @Nullable @Named("limit") Integer limit) {
        limit = limit == null ? DEFAULT_LIST_LIMIT : limit;
        Query<TempClass> query = ofy().load().type(TempClass.class).limit(limit);
        if (cursor != null) {
            query = query.startAt(Cursor.fromWebSafeString(cursor));
        }
        QueryResultIterator<TempClass> queryIterator = query.iterator();
        List<TempClass> tempClassList = new ArrayList<TempClass>(limit);
        while (queryIterator.hasNext()) {
            tempClassList.add(queryIterator.next());
        }
        return CollectionResponse.<TempClass>builder().setItems(tempClassList).setNextPageToken(queryIterator.getCursor().toWebSafeString()).build();
    }

    private void checkExists(String ID) throws NotFoundException {
        try {
            ofy().load().type(TempClass.class).id(ID).safe();
        } catch (com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Could not find TempClass with ID: " + ID);
        }
    }
}