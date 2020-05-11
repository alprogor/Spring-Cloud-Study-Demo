package com.progor.study.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyLoadBalancedRule extends AbstractLoadBalancerRule {

    // 这个choose方法就是选择哪个服务来进行调用
    public Server choose(ILoadBalancer lb, Object key) {
        // ILoadBalancer是服务注册列表
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//可用服务
            List<Server> allList = lb.getAllServers();// 所有服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                // 服务数为0
                return null;
            }

            // 看一下下面的代码（此段代码来自RandomRule），应该能判断出来，就是这里指定了返回的server，
            // 所以我们也在这里修改策略，假如说我们指定只调用8003的
//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            // 修改 start
            if (upList.size() == 0) {
                return null;
            }
            for (int i = 0; i < upList.size(); i++) {
                Server item = upList.get(i);
                int httpPort = item.getPort();
                // 你可以通过Server和ILoadBalancer的各种参数来自定义你的规则()
                if (httpPort == 8003) {
                    server = item; // 这里由于只是示例，所以就随便写了，所以安全逻辑并没有做完全。
                }
            }
            // 修改 end

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}

