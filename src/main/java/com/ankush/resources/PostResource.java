package com.ankush.resources;

import com.google.inject.Inject;
import com.ankush.dto.PostDto;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/redis/post")
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {
    private final JedisPool jedisPool;

    @Inject
    public PostResource(JedisPool jedisPool) {
        this.jedisPool = jedisPool;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response add(PostDto post) {
        Jedis jedis = jedisPool.getResource();
        jedis.setex(post.getKey(), post.getExpiry(), post.getValue());
        return Response.created(UriBuilder.fromResource(PostResource.class).build()).build();
    }
}
