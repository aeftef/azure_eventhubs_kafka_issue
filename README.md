Simple spark structured streaming project, reading data from event hubs kafka api.

It illustrates a problem with kafka admin api, that fails to list consumer groups details (throwing a NPE) when interacting with event hubs while a spark structured streaming client is connected to a topic.
