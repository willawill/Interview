class TreeNode
	attr_accessor :name, :children

	def initialize(name)
		@name = name
		@children = []
	end

	def add_child(new_node)
		@children << new_node
	end


	def traverse type
		unvisited = []
		result = ''
		unvisited << self
		while (!unvisited.empty?())
			node = unvisited.shift
			result += node.name
			unvisited = case type
									when :bfs
									unvisited + node.children
									when :dfs
									node.children + unvisited
								end
		end
		p result
	end
end

root = TreeNode.new("A")
B = TreeNode.new("B")
C = TreeNode.new("C")
D = TreeNode.new("D")
E = TreeNode.new("E")
root.add_child(B)
root.add_child(C)
B.add_child(D)
D.add_child(E)
root.traverse(:bfs)
root.traverse(:dfs)