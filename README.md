Simple spark structure streaming project, reading data from event hubs kafka api.

It illustrates a problem with kafka admin api, that fails to list consumer groups details (with a NPE) when interacting with event hubs while a spark structure streaming client is connected to a topic.