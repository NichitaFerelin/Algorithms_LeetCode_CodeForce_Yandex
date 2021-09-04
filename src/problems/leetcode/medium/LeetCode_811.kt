package problems.leetcode.medium

class LeetCode_811 {

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val domainsContainer = HashMap<String, Int>(cpdomains.size * 3)
        cpdomains.forEach { domain ->
            var domainCursor = 0
            while (domain[domainCursor] != ' ') {
                domainCursor++
            }

            val visitNumber = domain.substring(0, domainCursor).toInt()
            val domainStart = ++domainCursor

            var lastDot = -1
            while (domainCursor < domain.length) {
                if (domain[domainCursor] == '.') {
                    lastDot = domainCursor
                }
                domainCursor++
            }

            val postfix = domain.substring(lastDot + 1)
            domainsContainer[postfix] = domainsContainer.getOrDefault(postfix, 0) + visitNumber

            val fullDomain = domain.substring(domainStart, lastDot)
            val fullDomainKey = "$fullDomain.$postfix"
            domainsContainer[fullDomainKey] = domainsContainer.getOrDefault(fullDomainKey, 0) + visitNumber

            var cursor = domainStart
            while (cursor < lastDot && domain[cursor] != '.') {
                cursor++
            }
            if (domain[cursor] == '.' && lastDot != cursor) {
                val remainderDomains = domain.substring(cursor + 1, lastDot)
                val domains = remainderDomains.split(".")

                domains.forEach {
                    val resultAddress = "$it.$postfix"
                    domainsContainer[resultAddress] = domainsContainer.getOrDefault(resultAddress, 0) + visitNumber
                }
            }
        }

        val results = mutableListOf<String>()
        domainsContainer.forEach { map ->
            results.add("${map.value} ${map.key}")
        }
        return results
    }
}